from pydantic import BaseModel

class Member(BaseModel):

    id: str
    pw: str
    name: str
    email: str
    auth : int = 3

    class Config:
        orm_mode = True
