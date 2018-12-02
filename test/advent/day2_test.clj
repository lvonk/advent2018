(ns advent.day2-test
  (:require [clojure.test :refer :all]
            [advent.day2 :refer :all]))

(deftest day2-readFile
  (testing "readFile"
    (is (= 250 (count (readFile "./resources/day_2.txt"))))))

(deftest day2-prepareChecksum
  (testing "no matches"
    (is (= [0, 0] (prepareChecksum "abcdef"))))
  (testing "single 2s"
    (is (= [1, 0] (prepareChecksum "abcdee"))))
  (testing "single 3s"
    (is (= [0, 1] (prepareChecksum "abedee"))))
  (testing "2s and 3s"
    (is (= [1, 1] (prepareChecksum "abebee"))))
  (testing "two 2s"
    (is (= [1, 0] (prepareChecksum "abebef"))))
  (testing "two 3s"
    (is (= [0, 1] (prepareChecksum "afafaf")))))

(deftest day-checksumIds
  (testing "summing"
    (is (= [0,0] (checksumIds [[0,0]]))))
  (testing "summing"
    (is (= [1,1] (checksumIds [[0,0], [1,1]])))))

(deftest day-checksum
  (testing "checksum"
    (is (= 8892 (checksum "./resources/day_2.txt")))))
