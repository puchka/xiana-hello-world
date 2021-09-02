(ns xiana-hello-world.core
  (:require
   ;; mandatory modules to build/run any web application
   [xiana.core :as xiana]
   [framework.route.core :as route]
   [framework.webserver.core :as webserver])
  (:gen-class))

;; application route definitions
(def app-routes
  [["/" {:action
         #(xiana/ok
           (-> % (assoc :response
                        {:status 200 :body "Hello Word!"})))}]])

(defn -main
  "Application entry point."
  []
  ;; setup app routes
  (route/reset app-routes)
  ;; start app webserver
  (webserver/start []))
