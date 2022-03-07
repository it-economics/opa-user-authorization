# opa-user-authorization

## How to run

```shell
./gradlew build
```

```shell
docker-compose up
```

See <https://github.com/open-policy-agent/contrib/blob/main/api_authz/README.md>

## Check Access

```shell
curl -i \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiZ3JvdXBzIjpbeyJhcHAiOiJnYXMiLCJyb2xlcyI6WyJGTyIsIlBSSUNJTkciXX0seyJhcHAiOiJwb3dlciIsInJvbGVzIjpbIkZPIiwiQURNSU4iXX1dLCJpYXQiOjE1MTYyMzkwMjJ9.h48zeutpWPYX8vRqkolFMA1-7fhPhtAGQ1PjMXQzsO0" \
  http://localhost:8081/admin
```

The provided JWT has the following payload:

```json
{
  "sub": "1234567890",
  "name": "John Doe",
  "groups": [
    {
      "app": "gas",
      "roles": [
        "FO",
        "PRICING"
      ]
    },
    {
      "app": "power",
      "roles": [
        "FO",
        "ADMIN"
      ]
    }
  ],
  "iat": 1516239022
}
```
