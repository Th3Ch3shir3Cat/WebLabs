var express = require("express"),
    path = require("path"),
    bodyParser = require("body-parser"),
    ejs = require("ejs"),
    app = express();

var connection  = require('express-myconnection');
var mysql = require('mysql');

app.use(
    connection(mysql,{
        host: "localhost",
        user: "root",
        password: "",
        database: "jstechnika"
    },'request')
);

var indexRouter = require("./routes/index");
app.use(express.static(path.join(__dirname, "public")));
app.set("view engine", "ejs");
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());

app.set("views", path.join(__dirname, "views"));

app.use("/", indexRouter);


app.listen(3000,function () {
    console.log("Work on port 3000");
});

