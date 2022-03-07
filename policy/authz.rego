package authz

# HTTP API request
import input

default allow = false

allow {
  input.method == "GET"
  not has_admin_path
}

has_admin_path {
    input.path[_] == "admin"
}

allow {
    input.method == "GET"
    has_admin_path
    has_admin_role
}

has_admin_role {
    decodedToken := io.jwt.decode(input.token)
    decodedToken[1].groups[_].roles[_] == "ADMIN"
}

allow {
  input.path[_] == "info"
  input.method == "POST"
}