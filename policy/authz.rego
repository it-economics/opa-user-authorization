package authz

subordinates = {"alice": [], "charlie": [], "bob": ["alice"], "betty": ["charlie"]}

# HTTP API request
import input
# input = {
#   "path": ["finance", "salary", "alice"],
#   "user": "alice",
#   "method": "GET"
# }

default allow = false

# Allow users to get their own salaries.
allow {
  input.method == "GET"
  not has_admin_path
#  input.path = ["finance", "salary", username]
#  input.user == username
}

has_admin_path {
    input.path[_] == "admin"
}

# Allow managers to get their subordinates' salaries.
allow {
  input.path[_] == "info"
  input.method == "POST"
}