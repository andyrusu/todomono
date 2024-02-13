(ns main.index
  {:clj-kondo/ignore [:unresolved-symbol]}
  (:require [portfolio.ui :as ui]
            [portfolio.dumdom :refer-macros [defscene]]
            [todo.components :as comp]))

(defscene heading
  "Page Heading"
  :params {:title "Todo App"}
  [params portfolio-opts]
  (comp/heading params))

(defscene input
  "Generic input"
  :params {:options {:type "text"
                     :placeholder "Add a new todo"}}
  [params portfolio-opts]
  (comp/input params))

(defscene button
  "Generic button"
  :params {:options {:class "button is-success"}
           :text "Add"}
  [params portfolio-opts]
  (comp/button params))

(defscene new-todo-form
  "Top form to add a new item to the to-do list"
  :params {:input {:options {:type "text" 
                             :placeholder "Add a new todo"}}
           :button {:options {:class "button is-success"} 
                    :text "Add"}}
  [params portfolio-opts]
  (comp/add-new-item params))

(defscene list-item
  "Todo list item"
  :params {:title "Todo 1"
           :delete-label "Delete"}
  [params portfolio-opts]
  (comp/list-item params))

(defscene page
  "The complete page"
  :params {:heading {:title "Todo App"}
           :add-new-item {:input {:options {:type "text"
                                            :placeholder "Add a new todo"}}
                          :button {:options {:class "button is-success"}
                                   :text "Add"}}
           :items [{:title "Todo 1"
                    :delete-label "Delete"}
                   {:title "Todo 2"
                    :delete-label "Delete"}]}
  [params portfolio-opts]
  (comp/page params))

(ui/start!
 {:config {:css-paths ["https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"]}})
