Ext.require(['Ext.data.*', 'Ext.grid.*']);

Ext.define('User', {
    extend: 'Ext.data.Model',
    idProperty: 'userId',
    fields: ['name'],
    proxy: {
        type: 'rest',
        url: 'api/user',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        reader: {
            type: 'json',
            root: 'data'
        }
        ,
        writer: {
            type: 'json'
        }
        ,
        api: {
            create: 'api/user',
            read: 'api/user',
            update: 'api/user',
            destroy: 'api/user'
        }
    },
    validations: [{
        type: 'length',
        field: 'name',
        min: 1,
        max: 200
    }]
})
;

Ext.onReady(function () {

    var store = Ext.create('Ext.data.Store', {
            autoLoad: true,
            autoSync: true,
            model: 'User'
        })
        ;

    var rowEditing = Ext.create('Ext.grid.plugin.RowEditing');

    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: document.body,
        plugins: [rowEditing],
        width: 400,
        height: 500,
        frame: true,
        title: 'User',
        store: store,
        columns: [{
            text: 'ID',
            width: 40,
            sortable: true,
            dataIndex: 'userId'
        }, {
            text: 'Name',
            flex: 1,
            sortable: true,
            dataIndex: 'name',
            field: {
                xtype: 'textfield'
            }
        }],
        dockedItems: [{

            xtype: 'toolbar',
            items: [ {
                text: 'Добавить',
                iconCls: 'icon-add',
                handler: function () {
                    Ext.Msg.prompt("Добавить нового user", "Введите имя", function (btnText, sInput) {
                        if (btnText === 'ok') {
                            var u = new User();
                            u.set('userId', null);
                            u.set('name', sInput);
                            u.save({
                                success: function() {
                                    store.load();
                                }
                            });
                        }
                    }, this);

                }
            }, '-', {
                text: 'Удалить',
                iconCls: 'icon-delete',
                handler: function () {
                    var selection = grid.getView().getSelectionModel().getSelection()[0];
                    if (selection) {
                        store.remove(selection);
                    }
                }
            }]
        }]
    });
});


