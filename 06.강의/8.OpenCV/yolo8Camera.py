import cv2
import os
from ultralytics import YOLO


# YOLOv8 모델 로드
# 자동으로 coco 클래스 사용
model = YOLO("yolo26n.pt")   # n, s, m, l, x 중 선택 가능

'''
모델           정확도        속도
yolov8n           낮음       매우 빠름
yolov8s           중간       빠름
yolov8m           높음        보통
yolov8l/x       매우 높음    느림
'''

# 카메라 사용 시
#capture = cv2.VideoCapture(0)


# 동영상 파일 사용
capture = cv2.VideoCapture("Roadtraffic.mp4")


if not capture.isOpened():
    raise IOError("can't open capture!")

while True:
    ret, frame = capture.read()
    if not ret:
        break

    # YOLOv8 
    results = model(frame, conf=0.5)

    # 결과는 list → 첫 번째 결과 사용
    result = results[0]


    # 박스 정보 얻기
    boxes = result.boxes

    for box in boxes:
        # 좌표
        x1, y1, x2, y2 = map(int, box.xyxy[0])

        # confidence
        confidence = float(box.conf[0])

        # class id
        class_id = int(box.cls[0])
        class_name = model.names[class_id]

        # 박스 그리기
        cv2.rectangle(frame, (x1, y1), (x2, y2), (0,255,0), 2)

        # 텍스트 표시
        label = f"{class_name} ({confidence:.2f})"
        cv2.putText(frame, label, (x1, y1-10),
                    cv2.FONT_HERSHEY_SIMPLEX,
                    0.5, (0,255,0), 2)

    frame = cv2.resize(frame, (0,0), fx=1 ,fy=1, interpolation = cv2.INTER_AREA)
    cv2.imshow("YOLOv8 Detection", frame)

    if cv2.waitKey(10) == ord('q'):
        break


capture.release()
cv2.destroyAllWindows()

