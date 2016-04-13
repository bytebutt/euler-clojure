(ns project-euler.tools.numbers.triangular)

(defn triangular*
  "Returns an infinite seq of triangular numbers. Lazy."
  ([]
   (triangular* 0N 1N))
  ([sum n]
   (lazy-seq (cons sum (triangular* (+ sum n) (inc n))))))

(def triangular (triangular*))
