(ns project-euler.problems.problem-003
  (:require [project-euler.tools.numbers.primes :as primes]))

(defn solve []
  (apply max (primes/factorize 600851475143)))
