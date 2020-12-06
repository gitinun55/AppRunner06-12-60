////Update 5/10/63 project Apprunner
var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
extended: true
}));

app.listen(3000, function () {
    console.log('Node app is running on port 3000');
});

module.exports = app;

// default route
app.get('/', function (req, res) {
    return res.send({ error: true, message: 'Test Web API' })
    });
    
    // connection configurations
    var dbConn = mysql.createConnection({
        host: 'localhost',
        user: 'root', 
        password: '',
        database: 'data_running'
    });

// add event
app.post('/add_event', function (req,res){
    console.log("Add event")
    var data = req.body
    if (!data ) {
         return res.status(400).send({ error:true, message: 'Please Register Again' });
    }

    dbConn.query(`INSERT INTO add_event (id_user,pic_event,name_organizer,
        name_event,
        name_producer,
        date_reg_start,
        date_reg_end,
        objective,
        detail) VALUES (?,?,?,?,?,?,?,?,?)`, [req.body.id_user,req.body.pic_event,req.body.name_organizer,
        req.body.name_event,
        req.body.name_producer,
        req.body.date_reg_start,
        req.body.date_reg_end,
        req.body.objective,
        req.body.detail], function (error, results, fields) {

        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json({"status":"ok"});
            res.end()
        }
    });
});
    
//login
app.get('/login/:email/:password', function (req, res){
    console.log("login")
    let email = req.params.email;
    let password = req.params.password;
    
    if (!email) {
        return res.status(400).send({ error: true, message: 'Please provide email'});
    }
    if (!password) {
        return res.status(400).send({ error: true, message: 'Please provide password'});
    }
        
        dbConn.query('SELECT * FROM user where email = ? AND password = ?', [email,password], function (error, results, fields) {
            if (error){
                console.log(error)
                res.status(422).json({"status":"failed"});
                res.end()
            }else{
                res.status(200).json(results[0]);
                res.end()
            }
        });

    });

//insert register
app.post('/register', function(req,res){
    console.log("register")
    var register = req.body

    if(!register){
        return res.status(400).send({error:true,message: 'Please provide student'});
    }
    dbConn.query("INSERT INTO user SET ?", register , function(error, results, fieldds){
        if (error) throw error;
        return res.send(results);
    });
});

//insert deail_distance
app.post('/detail_distance', function(req,res){
    console.log("detail_distance")
    var register = req.body

    if(!register){
        return res.status(400).send({error:true,message: 'Please provide student'});
    }
    dbConn.query("INSERT INTO detail_distance SET ?", data , function(error, results, fieldds){
        if (error) throw error;
        return res.send(results);
    });
});

//show_event
app.get('/show_event', function (req, res) {
    dbConn.query('SELECT * FROM add_event where type = 1', function (error, results, fields) {
        console.log("show_event")
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

//search
app.get('/search_event/:status/:name_event', function (req, res){
    console.log("search")
    let name_event = req.params.name_event;
    let status = req.params.status;

    if (!name_event) {
        return res.status(400).send({ error: true, message: 'Please provide name_event'});
    }
    
    dbConn.query("SELECT * FROM add_event where name_event LIKE '%' ? '%' AND type = 1", [name_event,status], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

app.get('/get_idEvent/:name_event/:name_producer', function (req, res){
    console.log("Get id event")
    let name_organizer = req.params.name_organizer;
    let name_event = req.params.name_event;
    let name_producer = req.params.name_producer


    if (!name_event) {
        return res.status(400).send({ error: true, message: 'Please provide name_event'});
    }
    
    dbConn.query("SELECT * FROM add_event where name_event = ? AND name_producer = ?", [name_event,name_producer], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results[0]);
            console.log(results[0]);
            res.end()
        }
    });
});

app.get('/check_address/:id_user', function (req, res){
    console.log("Check Address")
    let id_user = req.params.id_user;


    if (!id_user) {
        return res.status(400).send({ error: true, message: 'Please provide id_user'});
    }
    
    dbConn.query("SELECT * FROM reg_address where id_user = ?", [id_user], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results[0]);
            res.end()
        }
    });
});

app.post('/add_distance', function (req,res){
    console.log("Add Distance")
    var data = req.body
    if (!data ) {
         return res.status(400).send({ error:true, message: 'Please Register Again' });
    }

    dbConn.query('INSERT INTO detail_distance (id_add,name_event,name_distance,distance,price) VALUES (?,?,?,?,?)', [req.body.id_add,req.body.name_event,req.body.name_distance,req.body.distance,req.body.price], function (error, results, fields) {

        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json({"status":"ok"});
            res.end()
        }
    });
});

//insert_address
app.post('/add_address', function (req,res){
    console.log("Add Address")
    var data = req.body;
    if (!data ) {
         return res.status(400).send({ error:true, message: 'Please Register Again' });
    }

    dbConn.query('INSERT INTO reg_address (Address,District,MueangDistrict,province,Country_number,Name,Tel,id_user) VALUES (?,?,?,?,?,?,?,?)', [req.body.Address,req.body.District,req.body.MueangDistrict,req.body.province,
    req.body.Country_number,req.body.Name,req.body.Tel,req.body.id_user], function (error, results, fields) {

        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json({"status":"ok"});
            res.end()
        }
    });
});

//reg_event
app.post('/reg_event', function (req,res){
    console.log("User Register event")
    var data = req.body
    if (!data ) {
         return res.status(400).send({ error:true, message: 'Please Register Again' });
    }

    dbConn.query('INSERT INTO reg_event (id_user,first_name,last_name,tel,id_card,nationality,blood,distance,emergency,relation,relationTel,id_add,name_event,name_producer,pic_event) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)'
        ,[req.body.id_user
        ,req.body.first_name
        ,req.body.last_name
        ,req.body.tel
        ,req.body.id_card
        ,req.body.nationality
        ,req.body.blood
        ,req.body.distance
        ,req.body.emergency
        ,req.body.relation
        ,req.body.relationTel
        ,req.body.id_add
        ,req.body.name_event
        ,req.body.name_producer
        ,req.body.pic_event], function (error, results, fields) {

        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json({"status":"ok"});
            res.end()
        }
    });
});


app.post('/upload_payment', function (req,res){
    console.log("upload_payment")
    var data = req.body;
    if (!data ) {
         return res.status(400).send({ error:true, message: 'Please Register Again' });
    }

    dbConn.query('INSERT INTO history_payment (id_user,id_add,image_link,date,time,bank) VALUES (?,?,?,?,?,?)', [req.body.id_user,req.body.id_add,req.body.image_link,
        req.body.date,req.body.time,req.body.bank], function (error, results, fields) {

        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json({"status":"ok"});
            res.end()
        }
    });
});


app.get('/show_event_profile', function(req,res){
    dbConn.query('SELECT * FROM reg_event where type = 1', function (error, results, fields) {
        console.log("show_event_profile")
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

app.get('/show_address/:first_name/:last_name', function(req,res){
    console.log("show_address")
    let first_name = req.params.first_name;
    let last_name = req.params.last_name;

    dbConn.query('SELECT * FROM reg_address where first_name = ? AND last_name = ?', 
    [first_name,last_name], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
})

//Update ProfileUser
app.put('/edit_ProfileUser/:id_user', function (req, res) {
    console.log("edit_ProfileUser")
    let id_user = req.params.id_user;
    let register = req.body

        dbConn.query("UPDATE user SET ? WHERE id_user = ?", 
        [register,id_user], function (error, results, fields ) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

//Update AddressUser
app.put('/edit_AddressUser/:id_address', function (req, res) {
    console.log("edit_AddressUser")
    let id_address = req.params.id_address;
    let data = req.body
    
        dbConn.query('UPDATE reg_address SET ? WHERE id_address = ?', 
        [data,id_address], function (error, results, fields ) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

//show_event_profile_user
app.get('/event_list/:id_user', function (req, res){
    console.log("get list event_user")
    let id_user = req.params.id_user;

    if (!id_user) {
        return res.status(400).send({ error: true, message: 'Please provide id_user'});
    }

    
    dbConn.query("SELECT id_add,name_event,name_producer,pic_event FROM reg_event Where id_user = ? GROUP BY name_event", [id_user], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

//show_event_profile_organizer
app.get('/event_organizer/:id_user', function (req, res){
    console.log("get list event_organizer")
    let id_user = req.params.id_user;

    if (!id_user) {
        return res.status(400).send({ error: true, message: 'Please provide name_organizer'});
    }

    
    dbConn.query("SELECT * FROM add_event Where id_user = ? AND type = 1", [id_user], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

app.get('/event_reg_list/:id_user/:id_add', function (req, res){
    console.log("get event reg")
    let id_user = req.params.id_user;
    let id_add = req.params.id_add;

    if (!id_user) {
        return res.status(400).send({ error: true, message: 'Please provide id_user'});
    }
    if (!id_add) {
        return res.status(400).send({ error: true, message: 'Please provide id_add'});
    }

    
    dbConn.query("SELECT * FROM reg_event Where id_user = ? AND id_add = ?", [id_user,id_add], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

//show_user_event
app.get('/show_user_event/:id_add', function (req, res){
    console.log("get event reg")
    let id_add = req.params.id_add;

    if (!id_add) {
        return res.status(400).send({ error: true, message: 'Please provide id_add'});
    }

    dbConn.query("SELECT * FROM reg_event WHERE id_add = ?", [id_add], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

app.get('/value_distance/:id_add/:name_event', function (req, res){
    console.log("get value distance")
    let id_add = req.params.id_add;
    let name_event = req.params.name_event;


    if (!id_add) {
        return res.status(400).send({ error: true, message: 'Please provide first_name'});
    }
    
    dbConn.query("SELECT * FROM detail_distance where id_add = ? AND name_event =?", [id_add,name_event], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

//show_list_name_reg_event
app.get('/list_name_reg_event/:id_add', function (req, res){
    console.log("get list_name_reg_event")
    let id_add = req.params.id_add;

    if (!id_add) {
        return res.status(400).send({ error: true, message: 'Please provide id_add'});
    }

    
    dbConn.query("SELECT * FROM reg_event Where id_add = ?", [id_add], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            res.end()
        }
    });
});

//approve_event
app.put('/approve_event/:id_reg_event', function (req, res) {
    console.log("edit_ProfileUser")
    let id_reg_event = req.params.id_reg_event;
    

        dbConn.query("UPDATE reg_event SET type_submit = 1 WHERE id_reg_event = ?", [id_reg_event], function (error, results, fields ) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results);
            console.log(results);
            res.end()
        }
    });
});


app.get('/show_user_payment/:id_add', function (req, res){
    console.log("show user payment")
    let id_add = req.params.id_add;

    if (!id_add) {
        return res.status(400).send({ error: true, message: 'Please provide id_add'});
    }

    
    dbConn.query("SELECT * FROM history_payment Where id_add = ?", [id_add], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results[0]);
            res.end()
        }
    });
});

app.get('/setName/:id_user', function (req, res){
    console.log("show user payment")
    let id_user = req.params.id_user;

    if (!id_user) {
        return res.status(400).send({ error: true, message: 'Please provide id_user'});
    }

    
    dbConn.query("SELECT * FROM user Where id_user = ?", [id_user], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results[0]);
            res.end()
        }
    });
});

app.get('/getId_reg_event/:id_user/:id_add', function (req, res){
    console.log("show user payment")
    let id_user = req.params.id_user;
    let id_add = req.params.id_add;

    if (!id_user) {
        return res.status(400).send({ error: true, message: 'Please provide id_user'});
    }
    if (!id_add) {
        return res.status(400).send({ error: true, message: 'Please provide id_add'});
    }

    
    dbConn.query("SELECT * FROM reg_event Where id_user = ? AND id_add = ?", [id_user,id_add], function (error, results, fields) {
        if (error){
            console.log(error)
            res.status(422).json({"status":"failed"});
            res.end()
        }else{
            res.status(200).json(results[0]);
            res.end()
        }
    });
});