import sqlite3

from repositories.member_repository import member_repository
from models.member import Member

class MemberService:

    def __init__(self):
        self.repository = member_repository()

    def getId(self, member_id:str):
        return self.repository.getId(member_id)

    def addMember(self, member:Member):
        return self.repository.addMember(member)
