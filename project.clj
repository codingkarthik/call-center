(defproject call-center "0.1.0-SNAPSHOT"
  :description "A call center backend service implemented using clojure."
  :url "https://github.com/codingkarthik/call-center"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [org.clojure/core.async "0.5.527"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler call-center.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
