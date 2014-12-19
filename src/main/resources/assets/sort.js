var grid = document.getElementById('table');

      grid.onclick = function(e) {
        var target = e && e.target || window.event.srcElement;

        if (target.tagName != 'TH') return;

        // Если TH -- сортируем
        sortGrid(target.cellIndex, target.getAttribute('data-type'));
      };

      function sortGrid(colNum, type) {
        var tbody = grid.getElementsByTagName('tbody')[0];

        // Составить массив из TR
        var rowsArray = [];
        for(var i = 0; i<tbody.children.length; i++) {
          rowsArray.push(tbody.children[i]);
        }


        // определить функцию сравнения, в зависимости от типа
        var compare;

        switch(type) {
          case 'number':
            compare = function(rowA, rowB) {
              return rowA.cells[colNum].innerHTML - rowB.cells[colNum].innerHTML;
            };
            break;
          case 'string':
            compare = function(rowA, rowB) {
              return rowA.cells[colNum].innerHTML > rowB.cells[colNum].innerHTML ? 1 : -1;
            };
            break;
           case 'date':{
                compare = function(rowA, rowB) {
                a=new Date(rowA.cells[colNum].innerHTML);
                b=new Date(rowB.cells[colNum].innerHTML);
                return a.getTime() > b.getTime()  ? 1 : -1;
                 };
                 break;
           }
        }

        // сортировать
        rowsArray.sort(compare);

        // Убрать tbody из большого DOM документа для лучшей производительности
        grid.removeChild(tbody);


        // Убрать TR из TBODY.
        // Присваивание tbody.innerHTML = '' не работает в IE
        //
        // на самом деле без этих строк можно обойтись!
        // при добавлении appendChild все узлы будут сами перемещены на правильное место!
        while(tbody.firstChild) {
          tbody.removeChild(tbody.firstChild);
        }


        // добавить результат в нужном порядке в TBODY
        for(var i=0; i<rowsArray.length; i++) {
          tbody.appendChild(rowsArray[i]);
        }

        grid.appendChild(tbody);}