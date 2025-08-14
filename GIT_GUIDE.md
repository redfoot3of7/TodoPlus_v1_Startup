# Git Guide for TodoPlus_v1_Startup
See APP_PLAN.md for the app plan.

## Branches
- dev ? active development
- main ? stable releases

## Daily Workflow
git status
git add .
git commit -m "message"
git push origin dev
git pull origin dev

## Release to Main
git checkout main
git pull origin main
git merge dev
git push origin main
