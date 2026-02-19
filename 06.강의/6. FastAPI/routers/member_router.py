from fastapi import APIRouter, HTTPException
from models.member import Member
from services.member_service import MemberService

#tages 안에 변수 확인 필요
router = APIRouter(prefix="/member", tags=["Member"])

service = MemberService()

@router.get("/getId/{member_id}", response_model=Member) # response_model : 리턴 할 데이터형
def getId(member_id:str):
    member = service.getId(member_id)
    if not member:
        raise HTTPException(status_code=404, detail="Member not found")
    return member

@router.post("/addmember", response_model=bool)
def addMember(member:Member):
    return service.addMember(member)





