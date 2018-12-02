(ns advent.day2
  (:gen-class))
(require '[clojure.string :as str])

(defn readFile [file]
  (str/split
    (slurp file) #"\n"))

(defn occurences [expected, checksummedId]
  (count (first (first (filter #(= expected (last %)) checksummedId)))))

(defn prepareChecksum [id]
  (def checksummedId (frequencies (str/split id #"")))
  [
    (occurences 2, checksummedId)
    (occurences 3, checksummedId)
  ])

(defn checksumIds [checksums]
  (reduce (fn [a, b] [(+ (first a) (first b)), (+ (last a) (last b))]) [0,0] checksums))

(defn checksum [file]
  (def totals (checksumIds (map #(prepareChecksum %1) (readFile file))))
  (* (first totals) (last totals)))
