(ns call-center.calls
  (:require [clojure.core.async :refer [<! >! <!! >!! go chan close!]]
            [clojure.tools.logging :as log]))


(def employees-count 5)
(def incoming-call-chan (chan))
(def employees-chan (chan employees-count))
(def employees ["naresh" "suresh" "priya" "raju" "karthik"])

(defn start-listening-to-calls
  []
  (go (while true
        (let [new-caller-phone (<! incoming-call-chan)]
          (log/infof "New incoming phone call from phone:%s" new-caller-phone)))))

(defn start-calls-handler
  []
  (go (doseq [employee employees]
        (>! employees-chan employee)))
  (start-listening-to-calls)
  (log/info "Listening to calls now!"))

(defn stop-calls-handler
  []
  (close! employees-count)
  (close! incoming-call-chan))
