"use client";

import { PropsWithChildren, createContext, useContext } from "react";
import { SortOrder } from "./column";
import { ColumnTypeInternal } from ".";

interface Context {
  columns: ColumnTypeInternal[];
  data: any[];
  onSort?: (key: string, order: SortOrder) => void;
  id: any;
}

interface Props extends PropsWithChildren, Context {}

const TableContext = createContext<Context | undefined>(undefined);

function useTable() {
  const table = useContext(TableContext);
  if (table === undefined) {
    throw new Error("cannot call useTable() outside table context");
  }
  return table;
}

function TableProvider({ children, ...context }: Props) {
  return <TableContext.Provider value={context}>{children}</TableContext.Provider>;
}

export { TableProvider, useTable };
