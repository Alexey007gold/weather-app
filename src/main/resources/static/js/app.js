var todayData = [];
var tomorrowData = [];
var recomendTodayURL = "clothes/recommendation/today";
var recomendTomorrowURL = "clothes/recommendation/tomorrow";
var recommendationsForToday =[];
var recommendationsForTomorrow =[];

var possibleWindDirections = ["east", "south", "west", "north"];

$(document).ready(function(){
    loadToday();
    loadRecommendations();
    
    //initTodayDetailedList();
    //initTomorrowDetailedList();
});

/*get remote data*/
function loadToday() {
    $.get("/weather/today", function(data){
        for (let i = 0; i < data.length; i++) {
            todayData.push(adaptData(data[i]));
        }
        initTopbar();
        initDetailedList(todayData, "#details-today");
    });
    $.get("/weather/tomorrow", function(data){
        for (let i = 0; i < data.length; i++) {
            tomorrowData.push(adaptData(data[i]));
        }
        initDetailedList(tomorrowData, "#details-tomorrow");
    });
    
}
function adaptData(rawDataItem) {
    let dataItem = {};
    dataItem.temp = convertTemperature(rawDataItem.tempCelsius);
    dataItem.cloudCoverage = rawDataItem.weatherDetailsEntity.weatherDescription,
    dataItem.wind = {
        speed: adaptWind(rawDataItem.weatherDetailsEntity.windSpeed),
        unit: "m/s"
    }
    for (let i = 0; i < possibleWindDirections.length; i++) {
        if (rawDataItem.weatherDetailsEntity.windDirFull.indexOf(possibleWindDirections[i] == 0)) {
            dataItem.wind.direction = possibleWindDirections[i];
        }
    }
    dataItem.pressure = {
        value: adaptPressure(rawDataItem.weatherDetailsEntity.pressure),
        unit: "mmHg"
    }
    dataItem.humidity = rawDataItem.weatherDetailsEntity.humidity;
    dataItem.dateTime = rawDataItem.dateTime;
    return dataItem;
}
function adaptWind(rawWindSpeed) {
    rawWindSpeed = rawWindSpeed.toString();
    return rawWindSpeed.substr(0, rawWindSpeed.indexOf(".")+2);
}
function adaptPressure(rawPressure) {
    rawPressure = rawPressure.toString();
    return rawPressure.substr(0, rawPressure.indexOf("."));
}
function convertTemperature(temp) {
    return temp;
}
/*get remote data end*/

/*topbar begin*/
function initTopbar(){
    let topbarData = getTopbarData();
    drawTopbarMain(topbarData);
    drawTopbarItem("Wind:", prepareWindInfo(topbarData.wind));
    drawTopbarItem("Pressure:", topbarData.pressure.value + topbarData.pressure.unit);
    drawTopbarItem("Humidity:", topbarData.humidity + "%");
}
function drawTopbarMain(data) {
    $(".topbar-temp").text(data.temp + "°");
    $(".topbar-weather-descr").text(data.cloudCoverage);
}
function drawTopbarItem(itemTitle, itemContent) {
    let item = $("#cloneable .topbar-weather-details-item").clone();
    item.find(".topbar-weather-details-item-title").html(itemTitle);
    item.find(".topbar-weather-details-item-content").html(itemContent);
    $("#topbarDetailsWrapper").append(item);
}
function prepareWindInfo(wind) {
    let windDirectionClass = "wind-" + wind.direction;
    let windIcon = $("#cloneable .wind").clone();
    windIcon.addClass(windDirectionClass);
    return wind.speed + wind.unit + ", " + windIcon.prop('outerHTML');
}
function getTopbarData() {
    return todayData[0];
}
/*topbar end*/

/*detailed list*/
function initDetailedList(data, containerAnchor) {
    for (let i = 0; i < data.length; i++) {
        renderDetailedItem(data[i], containerAnchor);
    }
}
function renderDetailedItem(dataItem, containerAnchor) {
    let newItem = $("#cloneable .weather-detailed-item-wrapper").clone();
    newItem.find(".weather-detailed-time").text(getTime(dataItem));
    newItem.find(".weather-detailed-temp").text(dataItem.temp);
    newItem.find(".weather-detailed-pressure").text(dataItem.pressure.value + dataItem.pressure.unit);
    $(containerAnchor).append(newItem);
}
function getTime(dataItem) {
    let time = dataItem.dateTime;
    return time.slice(time.length - 8, time.length-3);
}
/*detailed list end*/

function loadRecommendations(){
    $.get(recomendTomorrowURL, function(data){
        for (let i = 0; i < data.length; i++) {
            recommendationsForTomorrow.push(data[i]);
        }
        recommendationsForTomorrow.push(111);
        recommendationsForTomorrow.push(333);
    });
    $.get(recomendTodayURL, function(data){
        for (let i = 0; i < data.length; i++) {
            recommendationsForToday.push(data[i]);
        }
        recommendationsForToday.push(222);
        recommendationsForToday.push(444);
        populateRecommendList(recommendationsForToday);
    });
    $("#details-tomorrow-tab").on({
        "click" : function () {
            populateRecommendList(recommendationsForTomorrow);
        }
    });
    $("#details-today-tab").on({
        "click" : function () {
            populateRecommendList(recommendationsForToday);
        }
    })
}

function showRecomendForToday(arrRecommendations){
    let recommendationBlock = $("#recommendation-block");
    if(arrRecommendations.length > 0){
        if(!recommendationBlock.hasClass("d-none")){
            recommendationBlock.addClass("d-none");
        }
    }
}

function populateRecommendList(arrRecommendations){
    clearRecomendList();
    console.log(arrRecommendations);

    let recommendationBlock = $("#recommendation-block");
    console.log(recommendationBlock);
    if(arrRecommendations.length > 0) {
        console.log("Removing d-none");
        recommendationBlock.removeClass("d-none");
        let firstItem = $(".one-recommendation");
        firstItem.find(".recommendation-text").text(arrRecommendations[0]);
        for (let i = 1; i < arrRecommendations.length; i++) {
            let newItem = $(".one-recommendation").clone();
            newItem.find(".recommendation-text").text(arrRecommendations[i]);
            recommendationBlock.append(newItem);
        }
    }
}

function clearRecomendList(){
    console.log("Clear recom was invoked");
    $(".one-recommendation").not(':first').remove();
    let firstItem = $(".one-recommendation");
    firstItem.find(".recommendation-text").text("");
    $("#recommendation-block").addClass("d-none");
}