import { type PaginationItem as PaginationItemProps } from "@/app/types";
import clsx from "clsx";
import { FaEllipsis, FaChevronLeft, FaChevronRight } from "react-icons/fa6";

function PaginationItem({ type, page, onClick, disabled, selected }: PaginationItemProps) {
  if (type === "start-ellipsis" || type === "end-ellipsis") {
    return (
      <button
        className="flex items-center justify-center px-3 h-8 rounded select-none bg-background-secondary disabled:opacity-40 disabled:pointer-events-none"
        aria-label="gap"
        disabled={disabled}>
        <FaEllipsis />
      </button>
    );
  }

  if (type === "prev") {
    return (
      <button
        aria-label="prev"
        className="flex items-center justify-center px-3 h-8 rounded select-none bg-background-secondary disabled:opacity-40 disabled:pointer-events-none"
        disabled={disabled}
        onClick={onClick}>
        <FaChevronLeft />
      </button>
    );
  }

  if (type === "next") {
    return (
      <button
        aria-label="next"
        className="flex items-center justify-center px-3 h-8 rounded select-none bg-background-secondary disabled:opacity-40 disabled:pointer-events-none"
        disabled={disabled}
        onClick={onClick}>
        <FaChevronRight />
      </button>
    );
  }

  if (type === "page") {
    return (
      <button
        className={clsx(
          "flex items-center justify-center px-3 h-8 rounded select-none focus:outline-none bg-background-secondary disabled:opacity-40 disabled:pointer-events-none",
          selected && "bg-neutral-500"
        )}
        disabled={disabled}
        onClick={onClick}>
        {page}
      </button>
    );
  }

  return null;
}

export { PaginationItem };
