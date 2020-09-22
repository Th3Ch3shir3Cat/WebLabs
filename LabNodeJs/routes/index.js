var express = require("express");
var router = express.Router();
var ejs = require("ejs");

router.use(function(req, res, next) {
    console.log(req.method, req.url);
    next();
});

const mySql = require("mysql");

const dateBase = mySql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "jstechnika"
});

dateBase.connect((err) =>{
    if(err) throw err;
    console.log("Connected");
});


router.get("/", async (req, res, next) => {
    res.render("index", {title: "Спецтехника", isAdmin: false});
});

router.get("/main", async(req,res) =>{
    res.render("index", {title: "Спецтехника", isAdmin: false});
});

router.get("/typeTechnika", async(req,res) => {
    dateBase.query("SELECT * FROM typetechnika", function (error, rows, fields) {
        if (error) {
            console.log("Erorr in the query");
        } else {
            console.log("Successful query");
            var obj = {title: "Спецтехника", rows: rows};
            res.render("typeTechnika", {obj: obj});
        }
    })
});

router.get("/category/:id", async(req,res) =>{
    var sqlQuery = "SELECT * FROM category where PK_Type = " + req.params.id + ";";
    console.log(sqlQuery);
    dateBase.query(sqlQuery, function (error, rows, fields) {
        if (error) {
            console.log("Erorr in the query");
        } else {
            console.log("Successful query");
            var obj = {title: "Категории", rows: rows};
            res.render("category", {obj: obj});
        }
    })
});


router.get("/edit/(:id)", function (req,res,next) {
    var sqlQuery = "SELECT * FROM Nadstroika";
    var sqlQueryCar = "SELECT * FROM cars where ID = " + req.params.id + ";";
    dateBase.query(sqlQuery, function (error, rows, fields) {
        if (error) {
            console.log("Erorr in the query");
        } else {
            console.log("Successful query");
            var obj = {title: "Спецтехника", rows: rows};
            dateBase.query(sqlQueryCar, function (error, rows, fields) {
                if(error){
                    console.log("Erorr in the query");
                }
                else{
                    console.log(rows);
                    res.render("edit", {
                        obj: obj,
                        id: rows[0].ID,
                        Name: rows[0].Name,
                        ImgPath: rows[0].ImgPath,
                        Baza: rows[0].Baza,
                        DataBorn: rows[0].DataBorn
                    });
                }
            });

        }
    });
});

router.post("/cars/edit/(:id)", function (req,res,next) {

    var sqlQuery = "UPDATE cars SET Name = "+"'" + req.body.Name + "', ImgPath = '/images/" + req.body.ImgPath + "', DataBorn = '" + req.body.DataBorn
    + "', Baza = '" + req.body.Baza + "', PK_Nadstroika = " + req.body.PK_Nadstroika + " where ID = " + req.params.id + ";";
    console.log(sqlQuery);
    dateBase.query(sqlQuery, (err, result) => {
        if(err){
            console.log("Error query");
        }
        else
            res.redirect("/");
    })
});


/**
 * Реализация AJAX
 */

/**
 * Получаем список машин
 */
var curunt =router.route("/cars/(:id)");

curunt.get(function(req,res,next){
    req.getConnection(function(err,conn){
        if(err) return next("Cannot connect");
        var query = conn.query("SELECT c.ID, c.Name, c.ImgPath, c.DataBorn, c.baza, n.NameNad from cars c, nadstroika n where c.PK_Nadstroika = n.ID and c.PK_Category = " + req.params.id, function(err, rows){
            if(err){
                console.log(err);
                return next("MySql error, check your query");
            }
            var obj = {title: "Спецтехника", rows: rows};
            var query = conn.query("SELECT * from Nadstroika", function(err, rows){
               var objNad = {rows: rows};
                res.render("cars", {obj: obj, objNad: objNad});
            });
        });
    });
});

/**
 * Отправляем запрос на сервер
 */

curunt.post(function(req,res,next){

    var data = {
        Name: req.body.Name,
        ImgPath: "/images/" + req.body.ImgPath,
        DataBorn: req.body.DataBorn,
        Baza: req.body.Baza,
        PK_Nadstroika: req.body.PK_Nadstroika,
        PK_Category: req.params.id
    };

    req.getConnection(function(err, conn){
        if(err) return next("Cannot Connect");
        var query =conn.query("INSERT into cars set ?", data, function(err, rows){
            console.log(data);
            if(err){
                console.log(err);
                return next("Mysql error, check your query");
            }res.sendStatus(200);
        });

    });
});

/**
 * Удаляем запись
 */

curunt.delete(function(req,res,next){


    req.getConnection(function (err, conn) {

        if (err) return next("Cannot Connect");

        var query = conn.query("DELETE FROM cars  WHERE ID = ? ",req.params.id, function(err, rows){

            if(err){
                console.log(err);
                return next("Mysql error, check your query");
            }

            res.sendStatus(200);

        });
        //console.log(query.sql);

    });
});


module.exports = router;