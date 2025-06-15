idf_component_register(SRCS "spi_testing.c"
                        INCLUDE_DIRS "."
                        REQUIRES esp_lcd_ili9341)

set(EXTRA_COMPONENT_DIRS ${CMAKE_SOURCE_DIR}/components/esp-iot-solution/components/display/touch_panel/xpt2046)
