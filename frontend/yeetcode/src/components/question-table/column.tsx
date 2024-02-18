"use client";

import clsx from "clsx";
import { useState } from "react";
import { FaSort, FaSortUp, FaSortDown } from "react-icons/fa6";
import { useTable } from "./context";
import { ColumnTypeInternal } from ".";

enum SortOrder {
  ASC,
  DESC,
  NEUTRAL,
}

interface Props extends ColumnTypeInternal {}

const sortIcons = {
  [SortOrder.ASC]: FaSortUp,
  [SortOrder.DESC]: FaSortDown,
  [SortOrder.NEUTRAL]: FaSort,
};

function SortedButton({ order, size = "0.8em" }: { order: SortOrder; size?: string }) {
  return sortIcons[order]({ size });
}

function Column({ accessor: key, title, width, sortable, tooltip }: Props) {
  const [sortOrder, setSortOrder] = useState<SortOrder>(SortOrder.NEUTRAL);
  const { onSort } = useTable();

  const handleClick = () => {
    if (!sortable) return;
    let order = SortOrder.NEUTRAL;
    if (sortOrder === SortOrder.NEUTRAL) order = SortOrder.DESC;
    else if (sortOrder === SortOrder.DESC) order = SortOrder.ASC;
    if (onSort) onSort(key, order);
    setSortOrder(order);
  };

  return (
    <div
      key={title}
      role="columnheader"
      className="mx-2 py-[11px] font-normal text-neutral-400"
      style={{
        flex: `${width} 0 auto`,
        minWidth: 0,
        width: `${width}px`,
      }}>
      <div
        title={tooltip}
        className={clsx("flex justify-between items-center", sortable && "hover:text-gray-200 dark:hover:text-dark-gray-7 cursor-pointer")}
        onClick={handleClick}>
        <div className="overflow-hidden text-ellipsis select-none">{title}</div>
        {sortable && <SortedButton order={sortOrder} />}
      </div>
    </div>
  );
}

export { Column, SortOrder };
