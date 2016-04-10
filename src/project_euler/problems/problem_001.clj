(ns project-euler.problems.problem-001)

(defn solve []
  (let [divisible-by #(zero? (mod %2 %1))
        multiples (filter #(or (divisible-by 3 %) (divisible-by 5 %)) (range))]
    (reduce + (take-while #(< % 1000) multiples))))
