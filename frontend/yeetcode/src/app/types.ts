import { MouseEvent } from "react";

export interface PaginationProps {
  count: number;
  page: number;
  boundaryCount?: number;
  siblingCount?: number;
  showFirstButton?: boolean;
  showLastButton?: boolean;
  hideNextButton?: boolean;
  hidePrevButton?: boolean;
  disabled?: boolean;
  onClick?: (event: MouseEvent, page: number | null) => void;
}

export type PaginationItemType = "page" | "first" | "prev" | "next" | "last" | "end-ellipsis" | "start-ellipsis";

export interface PaginationItem {
  onClick: (event: MouseEvent<HTMLButtonElement>) => void;
  type: PaginationItemType;
  page: number | null;
  selected: boolean;
  disabled: boolean;
}
