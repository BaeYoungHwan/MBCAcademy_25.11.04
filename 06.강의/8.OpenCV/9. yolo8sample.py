import cv2
import os
from ultralytics import YOLO

# model load
model = YOLO('yolov8m.pt') # n, s, m, l, x
'''
모델           정확도        속도
yolov8n           낮음       매우 빠름
yolov8s           중간       빠름
yolov8m           높음        보통    ---> 적당함
yolov8l/x       매우 높음    느림
'''
# image load
image_path = os.path.join(os.getcwd(), "bus.jpg")
frame = cv2.imread(image_path)

if frame is None:
    raise IOError("이미지를 불러올 수없습니다")

results = model(frame, conf=0.5)
result = results[0]

# box의 정보 취득
for box in result.boxes:
    x1, y1, x2, y2 = map(int, box.xyxy[0])
    confidence = float(box.conf[0])
    class_id = int(box.cls[0])
    class_name = model.names[class_id]

    cv2.rectangle(frame, (x1, y1), (x2, y2), (0, 255, 0), 2)

    label = f"{class_name} ({confidence:.2f})"
    cv2.putText(frame, label, (x1, y1 - 10),
                cv2.FONT_HERSHEY_SIMPLEX,
                0.5, (0, 255, 0), 2)

cv2.imshow("YOLOv8 decetion", frame)
cv2.waitKey(0)
cv2.destroyAllWindows()





