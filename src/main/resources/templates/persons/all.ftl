<a href = "/person">Spenders</a>
<a href = "/category">Expense Categories</a>
<a href = "/expense">Expenses</a>

<div id="header">
    <h2>All persons</h2>
</div>
<div id="content">
    <fieldset>
        <legend>Add New Persons</legend>
        <form name="person" action="/person" method="post">
            Name : <input type="text" name="name" /><br/>
            <input type="submit" value="Save" />
        </form>
    </fieldset>

    <table class="datatable">
        <tr>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <#list model["persons"] as person>
            <tr>
                <td>${person.name}</td>
                <td>
                    <a href="person/delete/${person.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>

</div>