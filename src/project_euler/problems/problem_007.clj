(ns project-euler.problems.problem-007
  (:require [project-euler.tools.numbers.primes :as primes]))

(defn solve []
  (nth primes/primes 10000))
