var vue=new Vue({
    el:"#app",
    data: {
        control:'water',
    },
    created: function () {

    },
    methods: {
       sendOp:function () {

           jQuery.getJSON("./test",function (data) {
               console.log(data);
           })
       },
        sendCon:function () {
            jQuery.getJSON("./sendpy/"+this.control,function (data) {
                console.log(data);
            })
        }
    }
});