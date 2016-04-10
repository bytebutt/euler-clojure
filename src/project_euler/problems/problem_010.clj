(ns project-euler.problems.problem-010
  (:require [project-euler.tools.numbers.primes :as primes]))

(defn solve []
  (reduce + (primes/sieve 2000000)))
