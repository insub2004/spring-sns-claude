#!/bin/bash

BASE_URL="http://localhost:8080"

echo "=== 회원가입 ==="
curl -s -X POST "$BASE_URL/api/v1/users/signup" \
  -H "Content-Type: application/json" \
  -d '{"username": "testuser", "password": "password123"}' | jq .

echo ""
echo "=== 중복 사용자명 회원가입 (에러 케이스) ==="
curl -s -X POST "$BASE_URL/api/v1/users/signup" \
  -H "Content-Type: application/json" \
  -d '{"username": "testuser", "password": "password456"}' | jq .
