from fastapi import FastAPI

from routers.member_router import router as member_router

project = FastAPI()
project.include_router(member_router)


