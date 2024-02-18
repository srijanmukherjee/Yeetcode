import { useTable } from "./context";

function Body() {
  const { data, columns, id } = useTable();
  return (
    <div role="rowgroup">
      {data.map((row) => (
        <div
          role="row"
          key={row[id]}
          className="flex odd:bg-background even:bg-background-secondary"
          style={{
            flex: "1 0 auto",
            minWidth: 0,
          }}>
          {columns.map(({ accessor, width, render }) => (
            <div
              role="cell"
              key={accessor}
              className="mx-2 py-[11px] font-normal text-neutral-400"
              style={{
                flex: `${width} 0 auto`,
                minWidth: 0,
                width: `${width}px`,
              }}>
              {render ? render(row, accessor) : row[accessor]}
            </div>
          ))}
        </div>
      ))}
    </div>
  );
}

export { Body };
