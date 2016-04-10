(ns project-euler.problems.problem-002
  (:require [project-euler.tools.numbers.fibonacci :as fib]))

(defn solve []
  (reduce + (filter even? (take-while #(< % 4000000) fib/fibonacci))))
