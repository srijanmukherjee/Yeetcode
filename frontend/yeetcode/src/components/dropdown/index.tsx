import clsx from "clsx";
import { FaChevronDown, FaCheck } from "react-icons/fa6";
import { useEffect, useState } from "react";

interface Item {
  value: string;
  text: string;
}

interface Props {
  items: Item[];
  onSelect?: (value: string) => void;
  defaultSelected?: string;
}

function Dropdown({ items, onSelect, defaultSelected }: Props) {
  const [expanded, setExpanded] = useState(false);
  const [selected, setSelected] = useState(defaultSelected ? items.findIndex((item) => item.value === defaultSelected) : 0);

  const handleSelection = (index: number) => {
    setExpanded(false);
    setSelected(index);
    if (onSelect) onSelect(items[index].value);
  };

  // attach click event listener to window for dismissing dropdown when clicked outside
  useEffect(() => {
    const handleOutsideClick = () => {
      setExpanded(false);
    };

    window.addEventListener("click", handleOutsideClick);
    return () => {
      window.removeEventListener("click", handleOutsideClick);
    };
  }, []);

  return (
    <div className="relative">
      <button
        className="flex cursor-pointer items-center rounded px-3 py-1.5 text-left focus:outline-none whitespace-nowrap bg-background-secondary text-neutral-400 hover:bg-neutral-600 select-none"
        type="button"
        aria-haspopup="true"
        aria-expanded={expanded}
        onClick={(event) => {
          event.stopPropagation();
          setExpanded((v) => !v);
        }}>
        {items[selected].text}
        <FaChevronDown className={clsx("pointer-events-none ml-3 transition", expanded && "-rotate-180")} />
      </button>
      <ul
        className={clsx(
          "absolute mt-1 flex flex-col gap-2 max-h-56 overflow-auto rounded-lg p-2 z-dropdown focus:outline-none shadow-level2 dark:shadow-dark-level2 bg-background-secondary",
          !expanded && "hidden"
        )}
        aria-orientation="vertical"
        role="listbox"
        tabIndex={0}>
        {items.map(({ text, value }, index) => (
          <li
            key={value}
            className={clsx("text-neutral-100 relative flex h-8 cursor-pointer select-none py-1.5 pl-2 rounded-lg hover:bg-neutral-700")}
            onClick={(ev) => {
              ev.stopPropagation();
              handleSelection(index);
            }}
            role="option"
            tabIndex={-1}
            aria-selected={index === selected}>
            <div className="flex h-5 flex-1 items-center pr-2">
              <div className="whitespace-nowrap">{text}</div>
            </div>
            <span className={clsx("text-blue-500 flex items-center pr-2", index !== selected && "invisible")}>
              <FaCheck color="currentColor" className="h-4 w-4" />
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
}

export { Dropdown };
