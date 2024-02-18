import { PaginationItem, PaginationItemType, PaginationProps } from "@/app/types";
import { MouseEvent } from "react";

function range(start: number, end: number) {
  const length = end - start + 1;
  return Array.from({ length }, (_, i) => start + i);
}

export default function usePagination(props: PaginationProps) {
  const {
    count,
    page,
    onClick,
    boundaryCount = 1,
    siblingCount = 1,
    hideNextButton = false,
    hidePrevButton = false,
    showFirstButton = false,
    showLastButton = false,
    disabled = false,
  } = props;

  const handleClick = (event: MouseEvent, page: number | null) => {
    if (onClick) onClick(event, page);
  };

  const buttonPage = (type: string) => {
    switch (type) {
      case "first":
        return 1;
      case "prev":
        return page - 1;
      case "next":
        return page + 1;
      case "last":
        return count;
      default:
        return null;
    }
  };

  const startPages = range(1, Math.min(boundaryCount, count));
  const endPages = range(Math.max(count - boundaryCount + 1, boundaryCount + 1), count);
  const siblingsStart = Math.max(Math.min(page - siblingCount, count - boundaryCount - siblingCount * 2 - 1), boundaryCount + 2);
  const siblingsEnd = Math.min(Math.max(page + siblingCount, boundaryCount + siblingCount * 2 + 2), endPages.length > 0 ? endPages[0] - 2 : count - 1);

  const itemList = [];
  if (showFirstButton) itemList.push("first");
  if (!hidePrevButton) itemList.push("prev");

  itemList.push(...startPages);

  // start ellipsis
  if (siblingsStart > boundaryCount + 2) itemList.push("start-ellipsis");
  else if (boundaryCount + 1 < count - boundaryCount) itemList.push(boundaryCount + 1);

  // sibling pages
  itemList.push(...range(siblingsStart, siblingsEnd));

  // end ellipsis
  if (siblingsEnd < count - boundaryCount - 1) itemList.push("end-ellipsis");
  else if (count - boundaryCount > boundaryCount) itemList.push(count - boundaryCount);

  itemList.push(...endPages);

  if (!hideNextButton) itemList.push("next");
  if (showLastButton) itemList.push("last");

  const items: PaginationItem[] = itemList.map((item) => {
    if (typeof item === "number") {
      return {
        onClick: (event: MouseEvent<HTMLButtonElement>) => handleClick(event, item),
        type: "page" as PaginationItemType,
        page: item,
        selected: item === page,
        disabled,
      };
    } else {
      return {
        onClick: (event: MouseEvent) => handleClick(event, buttonPage(item)),
        type: item as PaginationItemType,
        page: buttonPage(item),
        selected: false,
        disabled: disabled || item.indexOf("ellipsis") !== -1 || (item === "next" && page >= count) || (item === "prev" && page <= 1),
      };
    }
  });

  return { items };
}
