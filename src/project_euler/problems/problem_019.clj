(ns project-euler.problems.problem-019)

(defn floor
  [n]
  (int (Math/floor n)))

(defn shift-month
  "Takes a numeric `month` value between 1 and 12 and shifts the value for use with
  Gauss' day of the week formula."
  [month]
  (inc (mod (- month 3) 12)))

(defn shift-year
  "Takes a numeric `year` value and decrements it if `shifted-month` is 11 or 12
  (i.e. the month is considered part of the previous year)."
  [year shifted-month]
  (if (or (= 11 shifted-month) (= 12 shifted-month))
    (dec year)
    year))

(defn day-of-week
  "Uses Gauss' method of determining the day of the week for the
  given `year`, `month`, and `day`. Sunday is 0 and Saturday is 6."
  [year month day]
  (let [m (shift-month month)
        y (shift-year year m)
        a day
        b (floor (- (* 2.6 m) 0.2))
        c (* 5 (mod y 4))
        d (* 4 (mod y 100))
        e (* 6 (mod y 400))]
    (mod (+ a b c d e) 7)))

(defn sunday?
  [[year month day]]
  (zero? (day-of-week year month day)))

(def dates
  (for [year (range 1901 2001)
        month (range 1 13)]
    [year month 1]))

(defn solve []
  (->> dates
       (filter sunday?)
       (count)))
