import { Body } from "./body";
import { SortOrder } from "./column";
import { TableProvider } from "./context";
import Header from "./header";

interface ColumnTypeCommon {
  title: string;
  sortable?: boolean;
  width?: number;
  tooltip?: string;
}

interface ColumnType<T> extends ColumnTypeCommon {
  accessor: keyof T;
  render?: (row: T, accessor: keyof T) => JSX.Element;
}

interface ColumnTypeInternal extends ColumnTypeCommon {
  accessor: string;
  render?: (row: any, accessor: string) => JSX.Element;
}

interface Props<T> {
  columns: ColumnType<T>[];
  data: T[];
  id: keyof T;
}

function QuestionTable<T>({ columns, data, id }: Props<T>) {
  const onSort = (key: string, order: SortOrder) => {
    console.log(key, order);
  };
  return (
    <TableProvider columns={columns as ColumnTypeInternal[]} data={data} id={id} onSort={onSort}>
      <div role="table" className="overflow-auto min-w-0">
        <div className="inline-block min-w-full">
          <Header />
          <Body />
        </div>
      </div>
    </TableProvider>
  );
}

export { QuestionTable, type ColumnType, type ColumnTypeInternal };
