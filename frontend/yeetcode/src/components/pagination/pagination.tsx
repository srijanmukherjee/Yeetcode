import usePagination from "@/hooks/usePagination";
import { PaginationItem } from "./pagination-item";
import { PaginationProps } from "@/app/types";

function Pagination(props: PaginationProps) {
  const { items } = usePagination(props);

  return (
    <nav role="navigation" className="flex flex-nowrap items-center space-x-2">
      {items.map((item, index) => (
        <PaginationItem key={index} {...item} />
      ))}
    </nav>
  );
}

export { Pagination };
