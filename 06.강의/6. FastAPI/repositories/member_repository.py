import psycopg2
from models.member import Member

class member_repository:

    def __init__(self):
        self.connection = psycopg2.connect(host="localhost", database="postgres", user="postgres", password="1234", port="5432")


    def getId(self, member_id:str):
        cursor = self.connection.cursor()

        sql = ("""
               SELECT id, pw, name, email, auth
               FROM member
               WHERE id = %s
                   """)
        cursor.execute(sql, (member_id, ))
        result = cursor.fetchone()
        cursor.close()

        if result == None:
            return None

        #tuple -> dictionary(json)
        return {

            "id": result[0],
            "pw": result[1],
            "name": result[2],
            "email": result[3],
            "auth": result[4]

        }

    def addmember(self, member:Member):
        cursor = self.connection.cursor()
        sql = ("""
               INSERT INTO member (id, pw, name, email, auth)
               values (%s, %s, %s, %s, 3)
        """)

        cursor.execute(sql, (member.id, member.pw, member.name, member.email))
        self.connection.commit()

        isSuccess = ( cursor.rowcount == 1 )
        cursor.close()

        return {
            "id": member.id,
            "pw": member.pw,
            "name": member.name,
            "email": member.email,
            "auth": member.auth
        }

    def close(self):
        self.connection.close()


