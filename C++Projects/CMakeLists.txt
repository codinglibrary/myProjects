cmake_minimum_required(VERSION 3.17)
project(C__Projects)

set(CMAKE_CXX_STANDARD 14)

file(GLOB DATA_STRUCTURE ./dataStructure/*.cpp)
file(GLOB DATA_H ./dataStructure/header/*.h)

add_executable(C__Projects main.cpp ${DATA_H} ${})