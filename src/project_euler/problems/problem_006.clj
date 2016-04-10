(ns project-euler.problems.problem-006)

(defn solve []
  (let [xs (range 1 101)
        sum-of-squares (reduce + (map #(* % %) xs))
        square-of-sum (Math/pow (reduce + xs) 2)]
    (- square-of-sum sum-of-squares)))
