import { Column } from "./column";
import { useTable } from "./context";

export default function Header() {
  const { columns } = useTable();

  return (
    <div className="border-b border-b-neutral-600">
      <div role="row" className="flex">
        {columns.map((column) => (
          <Column {...column} key={column.accessor} />
        ))}
      </div>
    </div>
  );
}
