(ns project-euler.tools.numbers.champernowne)

(defn- digit->int
  "Returns the integer represented by the character `c` where `c` is any
  character 0 through 9."
  [c]
  (Integer. (str c)))

(defn champernowne*
  "Returns a lazy sequence of the decimal digits of Champernowne's constant."
  ([]
   (champernowne* "1" 2))
  ([[c & cs] next]
   (if (nil? c)
     (champernowne* (str next) (inc next))
     (lazy-seq (cons (digit->int c) (champernowne* cs next))))))

(def champernowne (champernowne*))

(defn- digit-count
  "Returns the total number of decimal digits from digit category 1 through `k`."
  [k]
  (/ (inc (* (Math/pow 10 k) (dec (* 9 k)))) 9))

(defn- digit-category
  "Returns the digit category `n` belongs to."
  [n]
  (->> (range)
       (map #(vector % (digit-count %)))
       (drop-while #(> n (second %)))
       (first)
       (first)))

(defn champernowne-digit
  "Returns the `n`th decimal digit of Champernowne's constant. Based on Marcus Stuhr's
  solution in the Project Euler forums."
  [n]
  (let [k (digit-category n)
        a (Math/pow 10 (dec k))
        b (- n (digit-count (dec k)))
        num (dec (bigint (+ a (/ b k))))
        rem (mod b k)]
    (if (zero? rem)
      (digit->int (last (str num)))
      (digit->int (nth (str (inc num)) (dec rem))))))
