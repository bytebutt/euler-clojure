(ns project-euler.tools.numbers.fibonacci)

(defn fibonacci*
  "Returns an infinite seq of Fibonacci numbers. Lazy."
  ([]
   (fibonacci* 0N 1N))
  ([prev n]
   (lazy-seq (cons n (fibonacci* n (+ prev n))))))

(def fibonacci (fibonacci*))
