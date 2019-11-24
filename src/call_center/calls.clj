(ns call-center.calls
  (:require [clojure.core.async :refer [<! >! <!! >!! go chan close!]]
            [clojure.tools.logging :as log]))


(def incoming-call-chan (chan))

(defn start-listening-to-calls
  []
  (go (while true
        (let [new-caller-phone (<! incoming-call-chan)]
          (log/infof "New incoming phone call from phone:%s" new-caller-phone)))))

(defn stop-listening-to-calls
  []
  (close! incoming-call-chan))
