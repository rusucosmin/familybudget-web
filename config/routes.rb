Rails.application.routes.draw do
  root "members#index"
  resources :members
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
