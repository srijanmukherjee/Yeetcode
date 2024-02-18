"use client";

import { IoMdCheckmarkCircleOutline } from "react-icons/io";
import { ColumnType, QuestionTable } from "@/components/question-table";
import { Dropdown } from "@/components/dropdown";
import { Pagination } from "@/components/pagination";
import { useState } from "react";

interface Row {
  status: string;
  title: string;
  solution: string;
  acceptance: number;
  difficulty: string;
  frequency: number;
  slug: string;
}

const columns: ColumnType<Row>[] = [
  {
    accessor: "status",
    title: "Status",
    width: 52,
    render: ({ status }) => {
      if (status === "accepted") {
        return <IoMdCheckmarkCircleOutline className="h-[18px] w-[18px] text-green-500 inline-block shrink-0 stroke-current" fill="currentColor" />;
      }
      return <></>;
    },
  },
  {
    accessor: "title",
    title: "Title",
    sortable: true,
    width: 260,
    render: (row, accessor) => (
      <a href={`/problems/${row.slug}`} className="text-white hover:text-blue-500">
        {row[accessor]}
      </a>
    ),
  },
  {
    accessor: "solution",
    title: "Solution",
    sortable: false,
    width: 54,
  },
  {
    accessor: "acceptance",
    title: "Acceptance",
    sortable: true,
    width: 100,
    render: (row, accessor) => <>{(row[accessor] as number).toFixed(1)}%</>,
  },
  {
    accessor: "difficulty",
    title: "Difficulty",
    sortable: true,
    width: 84,
    render: ({ difficulty }) => {
      if (difficulty === "medium") return <span className="text-orange-300">Medium</span>;
      if (difficulty === "easy") return <span className="text-green-400">Easy</span>;
      if (difficulty === "hard") return <span className="text-red-500">Hard</span>;
      return <>{difficulty}</>;
    },
  },
  {
    accessor: "frequency",
    title: "Frequency",
    width: 84,
    tooltip: "Frequency of problems that appear in real interviews",
  },
];

const data: Row[] = [
  {
    title: "1. Two Sum",
    difficulty: "medium",
    frequency: 10,
    solution: "Yes",
    acceptance: 54,
    status: "accepted",
    slug: "two-sum",
  },
  {
    title: "2. Add Two Numbers",
    difficulty: "easy",
    frequency: 15,
    solution: "Yes",
    acceptance: 42.2,
    status: "",
    slug: "add-two-numbers",
  },
  {
    title: "3. Median of Two Sorted Arrays",
    difficulty: "hard",
    frequency: 15,
    solution: "Yes",
    acceptance: 39.3,
    status: "",
    slug: "median-of-two-sorted-arrays",
  },
  {
    title: "4. Longest Palindromic Substring",
    difficulty: "medium",
    frequency: 15,
    solution: "Yes",
    acceptance: 33.6,
    status: "",
    slug: "median-of-two-sorted-arrays",
  },
];

export default function Home() {
  const [page, setPage] = useState(1);
  return (
    <div className="main-container">
      <div className="grid grid-cols-4 gap-4 md:grid-cols-3 lg:grid-cols-4 lg:gap-6">
        <div className="col-span-4 md:col-span-2 lg:col-span-3">
          <QuestionTable columns={columns} data={data} id="title" />
          <div className="mt-4 flex flex-col-reverse flex-wrap gap-2 justify-center items-center lg:flex-row lg:justify-between">
            <Dropdown
              items={[
                {
                  text: "20 / page",
                  value: "20",
                },
                {
                  text: "50 / page",
                  value: "50",
                },
                {
                  text: "100 / page",
                  value: "100",
                },
              ]}
            />
            <Pagination count={152} page={page} siblingCount={1} onClick={(event, page) => page && setPage(page)} />
          </div>
        </div>
        <div className="col-span-4 md:col-span-1"></div>
      </div>
    </div>
  );
}
