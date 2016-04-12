(ns project-euler.tools.numbers.math)

(defn factorial
  "Returns the factorial of the number `n`."
  [n]
  (loop [product 1N
         value n]
    (if (<= value 0)
      product
      (recur (* product value) (dec value)))))
