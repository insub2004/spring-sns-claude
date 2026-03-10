#!/bin/bash

BASE_URL="http://localhost:8080"

echo "=== 로그인 ==="
curl -s -X POST "$BASE_URL/api/v1/users/login" \
  -c cookies.txt \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=testuser&password=password123" | jq .

echo ""
echo "=== 로그인 실패 - 잘못된 비밀번호 (에러 케이스) ==="
curl -s -X POST "$BASE_URL/api/v1/users/login" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=testuser&password=wrongpassword" | jq .

echo ""
echo "=== 로그인 실패 - 존재하지 않는 사용자 (에러 케이스) ==="
curl -s -X POST "$BASE_URL/api/v1/users/login" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=nouser&password=password123" | jq .

echo ""
echo "=== 로그아웃 ==="
curl -s -X POST "$BASE_URL/api/v1/logout" \
  -b cookies.txt \
  -c cookies.txt \
  -v