import os.path

import pandas as pd
import numpy as np
from sklearn.preprocessing import MinMaxScaler


#(step 1) RMS(Root mean square) 계산
def rms(data):
    return np.sqrt(np.mean(np.power(data - data.mean(), 2))) #신호의 평균적 에너지 산출

#(step 2) 시계열 윈도우 생성(Sliding Window)
def window(dataset, window_size=2):
    data_x = []
    for i in range(len(dataset) - window_size):
        data_x.append(dataset[i:i + window_size])
    return np.array(data_x)

#메인
file_path = 'merged_dataset_BearingTest_2.csv'

if not os.path.exists(file_path):
    print(f"error: file {file_path} not found")
else:
    raw_data = pd.read_csv(file_path)
    print(raw_data.head())

    numeric_data = raw_data.select_dtypes(include=[np.number])

    # Feature extraction(특징 추출)
    features = numeric_data.apply(rms)
    print(f"RMS data : \n{features.head()}")

    # Nomalization(정규화)
    scaler = MinMaxScaler()
    scaler_data = scaler.fit_transform(features.values.reshape(-1, 1))

    #Sliding Window 생성
    window_size = 2
    X_train = window(scaler_data, window_size)

    #결과 출력
    print(f"final data : {X_train.shape}")
    print(f"window size : {window_size}")
