(ns project-euler.tools.numbers.collatz)

(defn collatz
  "Returns a vector representing the Collatz sequence starting with `n` and ending with 1."
  [n]
  (if (<= n 0)
    []
    (loop [chain []
           value n]
      (cond
        ; Reached the end of the chain.
        (= 1 value)
        (conj chain value)
        ; Even case.
        (even? value)
        (recur (conj chain value) (/ value 2))
        ; Odd case.
        :else
        (recur (conj chain value) (inc (* 3 value)))))))
